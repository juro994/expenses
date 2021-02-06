<template>
    <div v-if="expenses && expenses.length > 0">
        <table>
            <template v-for="expense in expenses">
                <tr v-bind:key="expense.name">
                    <td>{{expense.name}}</td>
                    <td>{{expense.amount}}</td>
                    <td>{{getFormattedDate(expense.modified)}}</td>
                </tr>
            </template>
        </table>
    </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
    expenses: Array
  },
  data () {
    return {
    }
  },
  methods: {
    getFormattedDate (dateString: string) {
      const date = new Date(dateString)
      return date.toLocaleDateString('en-US')
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
table, td, tr{
    border: 1px solid blue;
    width: 100%;
}
</style>
