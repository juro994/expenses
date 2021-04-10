<template>
  <div v-if="expenses && expenses.length > 0">
    <v-data-table dense :items="expenses" :headers="headers" hide-default-footer>
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
        { text: 'Name', value: 'name' },
        { text: 'Modified', value: 'modified' },
        { text: 'Amount', value: 'amount' }
      ]
    }
  },
  methods: {
    getFormattedDate (dateString) {
      const date = new Date(dateString)
      const options = { day: 'numeric', month: 'numeric' }
      return date.toLocaleDateString('pl-PL', options)
    }
  }
})
</script>
