<template>
  <v-card class="ma-2 elevation-3">
    <v-card-title class="headline">
      Summary
    </v-card-title>
    <v-card-text>
      <v-progress-circular
      :rotate="-90"
      :size="100"
      :width="15"
      :value="70"
      color="primary"
    >
      1200
    </v-progress-circular>
    </v-card-text>
  </v-card>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  props: {

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
