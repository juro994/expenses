package sk.juraj.projects.expenses.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sk.juraj.projects.expenses.dto.ExpenseCreateDTO;
import sk.juraj.projects.expenses.dto.ExpenseGetDTO;
import sk.juraj.projects.expenses.dto.ImmutableExpenseCreateDTO;
import sk.juraj.projects.expenses.entity.Category;
import sk.juraj.projects.expenses.entity.Expense;
import sk.juraj.projects.expenses.entity.User;
import sk.juraj.projects.expenses.repository.ExpenseRepository;

@ExtendWith(MockitoExtension.class)
@EnableJpaAuditing
public class ExpenseAddingServiceTest {

    @Mock
    private CategoryService categoryService;

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private ExpenseAddingService expenseAddingService;

    @Test
    void addExpense() {
        // given
        final ExpenseCreateDTO expenseInput = ImmutableExpenseCreateDTO.builder()
            .name("An expense")
            .categoryId(Optional.of(123L))
            .amount(BigDecimal.valueOf(250))
            .build();

        final Category category = mock(Category.class);
        // when(category.getMonthlyBudget()).thenReturn(BigDecimal.valueOf(10_000));
        when(category.getId()).thenReturn(123L);

        final User user = mock(User.class);

        when(this.userService.getCurrentUser())
        .thenReturn(user);

        final Expense expenseToSave = new Expense();
        expenseToSave.setAmount(BigDecimal.valueOf(250));
        expenseToSave.setTitle("An expense");
        expenseToSave.setCategory(category);
        expenseToSave.setUser(user);

        final Expense expenseSaved = mock(Expense.class);
        when(expenseSaved.getAmount()).thenReturn(BigDecimal.valueOf(250));
        when(expenseSaved.getTitle()).thenReturn("An expense");
        when(expenseSaved.getCategory()).thenReturn(category);
        when(expenseSaved.getModified()).thenReturn(LocalDateTime.now());

        when(this.categoryService.getCategoryEntityById(123L))
            .thenReturn(category);

        when(this.expenseRepository.save(eq(expenseToSave)))
            .thenReturn(expenseSaved);

        // when
        ExpenseGetDTO returnedExpense = this.expenseAddingService.addExpense(expenseInput);

        // then
        assertEquals(BigDecimal.valueOf(250), returnedExpense.getAmount());
    }
}
