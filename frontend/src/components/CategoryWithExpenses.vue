<template>
  <div class="category-with-expenses shadow-effect" :style="cssVars">
    <div class="card-title">
      <h2>{{ category.name }}</h2>
    </div>
    <add-expense-dialog
      v-on:newExpenseAdded="fetchCategories"
      ref="addExpenseModal"
      :category="category"
    />
    <expenses :expenses="category.expenses" />
    <button
      class="add-expense-button"
      @click="$refs.addExpenseModal.openModal()"
    >
      +
    </button>
  </div>
</template>

<script>
import Vue from 'vue'
import Expenses from './Expenses.vue'
import AddExpenseDialog from './AddExpenseDialog.vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
    category: Object
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
    cssVars () {
      return {
        '--background-color': this.category.colorCode,
        '--lighter-background-color': this.adjust(this.category.colorCode, 40)
      }
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
[draggable=true] {
  cursor: move;
}

.category-with-expenses {
  margin: 10px;
  background-color: var(--background-color);
  flex-basis: 300px;
}
.add-expense-button {
  border-radius: 100%;
  border: 1px solid white;
  background-color: var(--background-color);
  filter: brightness(95%);
  color: white;
  height: 30px;
  width: 30px;
  margin: 10px;
}

.add-expense-button:hover {
  filter: brightness(105%);
}
.add-expense-button:active {
  filter: brightness(95%);
}
.shadow-effect {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
}

/* On mouse-over, add a deeper shadow */
.shadow-effect:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

</style>
