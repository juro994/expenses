/* eslint-disable indent */
<template>
  <div class="color-option" :style="cssVars">
      <input
        type="radio"
        :id="colorOption.id"
        v-model="radioButtonValue"
        :value="colorOption"
        :name="radioGroupName"
      />
      <label :for="colorOption.id"></label>
    </div>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  name: 'colorPicker',
  props: {
    colorOption: Object,
    pickedColor: Object,
    radioGroupName: String
  },
  computed: {
    radioButtonValue: {
      get: function () {
        return this.pickedColor
      },
      set: function () {
        this.$emit('change', this.colorOption)
      }
    },
    cssVars () {
      return {
        '--background-color': this.colorOption.colorCode
      }
    }
  }
})
</script>

<style scoped>
.color-option input {
  display: none;
}

.color-option label:before {
  content: " ";
  display: inline-block;
  position: relative;
  top: 5px;
  margin: 0 5px 0 0;
  width: 20px;
  height: 20px;
  border-radius: 11px;
  border: 2px solid var(--background-color);
  background-color: var(--background-color);
}

.color-option input[type="radio"]:checked + label:before {
  border: 2px solid white;
}

.color-option input[type="radio"]:checked + label:before {
  border: 2px solid white;
}
</style>
