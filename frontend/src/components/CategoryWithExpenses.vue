<template>
  <div class="category-with-expenses">
    <h2>{{category.name}}</h2>
    <expenses :expenses="category.expenses" />
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import Expenses from './Expenses.vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
    category: Object
  },
  components: {
    Expenses
  },
  data () {
    return {
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.category-with-expenses {
    border: 1px solid red;
    border-radius: 5px;
}
</style>
