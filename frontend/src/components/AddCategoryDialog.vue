<template>
    <modal ref="modal">
        <template v-slot:header>
          <h1>Add a new Category</h1>
        </template>

        <template v-slot:body>
          <form @submit.prevent="postNewCategory">
            <input type="text" v-model="newCategoryName" />
            <button type="submit">
              +
            </button>
          </form>
        </template>

        <template v-slot:footer>
          <div>
            <button @click="$refs.modal.closeModal()">Cancel</button>
            <button @click="$refs.modal.closeModal()">Save</button>
          </div>
        </template>
      </modal>
</template>

<script lang="ts">
import Vue from 'vue'
import Modal from './Modal.vue'

export default Vue.extend({
  name: 'addCategoryDialog',
  components: {
    Modal
  },
  data () {
    return {
      newCategoryName: ''
    }
  },
  methods: {
    openModal () {
      const modal = this.$refs.modal as any
      modal.openModal()
    },
    postNewCategory () {
      console.log('Hello world')
      const categoryToPost = {
        name: this.newCategoryName
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
            const modal = this.$refs.modal as any
            modal.closeModal()
          }
        })
    }
  }
})
</script>
