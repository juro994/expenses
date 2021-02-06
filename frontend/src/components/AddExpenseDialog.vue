<template>
    <modal ref="modal">
        <template v-slot:header>
          <h1>Add a new Expense</h1>
        </template>

        <template v-slot:body>
          <form @submit.prevent="postNewExpense">
            <input type="text" v-model="newExpenseName" />
            <input type="text" v-model="newExpenseAmount" />
            <button type="submit">
              +
            </button>
        </form>
        </template>
      </modal>
</template>

<script lang="ts">
import Vue from 'vue'
import Modal from './Modal.vue'

export default Vue.extend({
  name: 'addExpenseDialog',
  components: {
    Modal
  },
  props: {
    category: Object
  },
  data () {
    return {
      newExpenseName: '',
      newExpenseAmount: null
    }
  },
  methods: {
    openModal () {
      const modal = this.$refs.modal as any
      modal.openModal()
    },
    postNewExpense () {
      const expenseToPost = {
        name: this.newExpenseName,
        amount: this.newExpenseAmount
      }
      fetch(process.env.VUE_APP_API_URL + 'categories/' + this.category.id + '/expenses/', {
        method: 'POST',
        body: JSON.stringify(expenseToPost),
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
            this.$emit('newExpenseAdded')
            const modal = this.$refs.modal as any
            modal.closeModal()
          }
        })
    }
  }
})
</script>
