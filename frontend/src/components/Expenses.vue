<template>
  <div v-if="expenses && expenses.length > 0">
    <v-data-table class="my-awesome-table" :items="expenses" :headers="headers" :mobile-breakpoint="0" hide-default-footer>
      <template v-slot:item.modified="{ item }">
        {{ getFormattedDate(item.modified) }}
    </template>
    </v-data-table>
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
    return {
      headers: [
        { text: 'Name', value: 'name', width: '70%' },
        { text: 'Date', value: 'modified', width: '25%' },
        { text: '€', value: 'amount', width: '10%' }
      ]
    }
  },
  methods: {
    getFormattedDate (dateString) {
      const date = new Date(dateString)
      const options = { day: 'numeric', month: 'numeric' }
      return date.toLocaleDateString('sk-SK', options)
    }
  }
})
</script>

<style>
  .my-awesome-table{
    table-layout : fixed;
  }
</style>
