<template>
    <table>
        <template v-for="expense in expenses">
            <tr v-bind:key="expense.name">
                <td>{{expense.name}}</td>
                <td>{{expense.amount}}</td>
            </tr>
        </template>
    </table>
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
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
