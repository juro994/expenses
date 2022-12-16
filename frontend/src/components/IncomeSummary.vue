<template>
  <v-card class="ma-2 elevation-3">
    <v-card-title class="headline">
      Income
    </v-card-title>
    <income-items v-bind:incomeItems="incomeItems" />
    <v-card-actions>
      <add-income-item-dialog
        v-on:newIncomeItemAdded="fetchMonthlyData"
        ref="addIncomeItemModal"
      />
      <v-spacer></v-spacer>
          <span class="subheading mr-2">Total:</span>
          <span class="subheading mr-1">1500</span>
    </v-card-actions>
  </v-card>
</template>

<script>
import Vue from 'vue'

import IncomeItems from './IncomeItems.vue'
import AddIncomeItemDialog from './AddIncomeItemDialog.vue'

export default Vue.extend({
  props: {
    incomeItems: Array
  },
  components: {
    IncomeItems,
    AddIncomeItemDialog
  },
  data () {
    return {
    }
  },
  methods: {
    fetchMonthlyData () {
      this.$emit('fetchMonthlyData')
    }
  },
  computed: {
  }
})

</script>
