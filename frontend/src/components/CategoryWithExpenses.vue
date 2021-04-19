<template>
  <v-card class="ma-2">
    <v-card-title class="headline" v-text="category.name">
    </v-card-title>
    <v-card-text>
      <expenses :expenses="category.expenses" />
    </v-card-text>
    <v-card-actions>
      <add-expense-dialog
        v-on:newExpenseAdded="fetchCategories"
        ref="addExpenseModal"
        :category="category"
      />
      <v-spacer></v-spacer>
          <span class="subheading mr-2">Total:</span>
          <span class="subheading mr-1">{{totalAmountSpent}}</span>
          <span class="mr-1">/</span>
          <span class="subheading mr-1">{{category.monthlyBudget}}</span>
    </v-card-actions>
    <v-progress-linear
        absolute
        bottom
        :color="spendingColor"
        :value="percentageOfBudgetSpent"
      ></v-progress-linear>
  </v-card>
</template>

<script>
import Vue from 'vue'
import Expenses from './Expenses.vue'
import AddExpenseDialog from './AddExpenseDialog.vue'

export default Vue.extend({
  props: {
    category: {}
  },
  components: {
    Expenses,
    AddExpenseDialog
  },
  data () {
    return {
      newExpenseName: '',
      newExpenseAmount: null
    }
  },
  methods: {
    fetchCategories () {
      this.$emit('newCategoryAdded')
    },
    clearInputs () {
      this.newExpenseName = ''
      this.newExpenseAmount = null
    },
    adjust (color, amount) {
      return '#' + color.replace(/^#/, '').replace(/../g, color => ('0' + Math.min(255, Math.max(0, parseInt(color, 16) + amount)).toString(16)).substr(-2))
    }
  },
  computed: {
    totalAmountSpent () {
      return this.category.expenses.reduce((a, b) => a + b.amount, 0)
    },
    percentageOfBudgetSpent () {
      const totalAmount = this.totalAmountSpent
      const percentageSpent = (totalAmount / this.category.monthlyBudget) * 100
      return percentageSpent
    },
    spendingColor () {
      if (this.percentageOfBudgetSpent < 70) {
        return 'green'
      } else if (this.percentageOfBudgetSpent >= 70 && this.percentageOfBudgetSpent < 85) {
        return 'orange'
      } else {
        return 'red'
      }
    }
  }
})

</script>
