/* eslint-disable indent */
<template>
    <modal ref="modal" :backgroundColor="pickedColor.colorCode">
        <template v-slot:header>
          <h1>Add a new Category</h1>
        </template>

        <template v-slot:body>
          <form @submit.prevent="postNewCategory">
            <input type="text" v-model="newCategoryName" />
            <color-picker :colorOptions="colorOptions" @change="newColorPicked" />
            <button type="submit">
              +
            </button>
          </form>
        </template>
      </modal>
</template>

<script>
import Vue from 'vue'
import Modal from './Modal.vue'
import ColorPicker from './ColorPicker.vue'

export default Vue.extend({
  name: 'addCategoryDialog',
  components: {
    Modal,
    ColorPicker
  },
  data () {
    return {
      newCategoryName: '',
      colorOptions: [
        {
          colorCode: '#DAABD9',
          id: 'PINK'
        },
        {
          colorCode: '#A4D2A3',
          id: 'GREEN'
        },
        {
          colorCode: '#A7E1F0',
          id: 'BLUE'
        }
      ],
      pickedColor: {}
    }
  },
  methods: {
    openModal () {
      const modal = this.$refs.modal
      this.pickedColor = {}
      modal.openModal()
    },
    postNewCategory () {
      console.log(this.pickedColor)
      const categoryToPost = {
        name: this.newCategoryName,
        colorCode: this.pickedColor.colorCode
      }
      fetch(process.env.VUE_APP_API_URL + 'categories/', {
        method: 'POST',
        body: JSON.stringify(categoryToPost),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then((response) => response.json())
        .then((data) => {
          if (data.status && data.status !== 'OK') {
            alert(data.message)
          }
          if (data.name) {
            this.$emit('newCategoryAdded')
            const modal = this.$refs.modal
            modal.closeModal()
          }
        })
    },
    newColorPicked (newColor) {
      this.pickedColor = newColor
    }
  }
})
</script>
