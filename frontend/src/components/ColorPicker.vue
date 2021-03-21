/* eslint-disable indent */
<template>
  <div>
    <div class="color-options"
      v-for="colorOption in colorOptions"
      v-bind:key="colorOption.id"
    >
      <color-option :colorOption="colorOption" :pickedColor="pickedColor" radioGroupName="colors" @change="changeValue"/>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import ColorOption from './ColorOption.vue'

export default Vue.extend({
  components: { ColorOption },
  name: 'colorPicker',
  props: {
    colorOptions: Array
  },
  data () {
    return {
      pickedColor: {}
    }
  },
  methods: {
    changeValue: function (newColor) {
      this.pickedColor = newColor
      this.$emit('change', newColor)
    }
  }
})
</script>

<style scoped>
.color-options {
  display: inline-block;
  position: relative;
  padding: 2px;
}
</style>
