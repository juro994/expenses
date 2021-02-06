<template>
  <div class="category-with-expenses">
    <h2>{{category.name}}</h2>
    <button @click="$refs.addExpenseModal.openModal()">+</button>
    <add-expense-dialog v-on:newExpenseAdded="fetchCategories" ref="addExpenseModal" :category="category" />
    <expenses :expenses="category.expenses" />
  </div>
</template>

<script lang="ts">
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
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.category-with-expenses {
    border: 1px solid red;
    border-radius: 5px;
    flex-basis: 20%;
}
</style>
