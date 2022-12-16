<template>
  <v-card class="ma-2 elevation-3" v-if="totalSpent > 0 && budgetForTheMonth > 0">
    <v-card-title class="headline">
      Summary
    </v-card-title>
    <v-card-text>
      <v-progress-circular
      :rotate="-90"
      :size="100"
      :width="15"
      :value="totalSpent/budgetForTheMonth*100"
      color="primary"
    >
      Spent {{totalSpent}}
      <br/>
      of {{budgetForTheMonth}}
    </v-progress-circular>
    </v-card-text>
  </v-card>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  props: {
    budgetForTheMonth: {
      type: Number,
      default: 0
    },
    totalSpent: {
      type: Number,
      default: 0
    }
  },
  components: {

  },
  data () {
    return {
    }
  },
  methods: {
  },
  computed: {
  }
})

</script>
