<template>
  <div v-if="expenses && expenses.length > 0">
    <table>
      <tr>
        <th class="expenses-title">Title</th>
        <th class="expenses-date">Date</th>
        <th class="expenses-amount">Amount</th>
      </tr>
      <template v-for="expense in expenses">
        <tr class="table-row" v-bind:key="expense.name">
          <td>{{ expense.name }}</td>
          <td>{{ getFormattedDate(expense.modified) }}</td>
          <td>{{ expense.amount }}</td>
        </tr>
      </template>
    </table>
  </div>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
    expenses: Array
  },
  data () {
    return {}
  },
  methods: {
    getFormattedDate (dateString) {
      const date = new Date(dateString)
      const options = { day: 'numeric', month: 'numeric' }
      return date.toLocaleDateString('en-US', options)
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
table {
  border-collapse: collapse;
  width: 100%;
  text-align: left;
}
tr {
  border-top: 1px solid white;
  width: 100%;
  height: 40px;
  border-bottom: 1px solid white;
}

td, th {
  padding-left: 10px;
  padding-right: 10px;
}

.expenses-title {
  width: 60%;
}

.expenses-amount {
  width: 20%;
}

.expenses-date {
  width: 20%;
}

tr:nth-child(even):not(td) {background-color: var(--darker-background-color);}
</style>
