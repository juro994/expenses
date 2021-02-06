<template>
  <div class="hello">
    <h1>My Expenses</h1>
    <div class="categories-with-expenses">
      <template v-for="category in categories">
        <category-with-expenses v-on:newCategoryAdded="fetchCategories" v-bind:key="category.name" v-bind:category="category" />
      </template>
      <button @click="$refs.addCategoryModal.openModal()">+</button>
      <add-category-dialog v-on:newCategoryAdded="fetchCategories" ref="addCategoryModal"/>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import CategoryWithExpenses from './CategoryWithExpenses.vue'
import AddCategoryDialog from './AddCategoryDialog.vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
  },
  components: {
    CategoryWithExpenses,
    AddCategoryDialog
  },
  data () {
    return {
      categories: []
    }
  },
  mounted () {
    this.fetchCategories()
  },
  methods: {
    fetchCategories () {
      console.log(process.env.VUE_APP_API_URL)
      fetch(process.env.VUE_APP_API_URL + 'categories/')
        .then((response) => response.json())
        .then((data) => {
          this.categories = data
        })
    }
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.categories-with-expenses {
  display: flex;
  flex-wrap: wrap;
}
</style>
