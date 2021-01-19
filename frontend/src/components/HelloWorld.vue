<template>
  <div class="hello">
    <h1>Categories</h1>
    <template v-for="category in categories">
      <p v-bind:key="category.name">{{ category.name }}</p>
    </template>
    <input v-model="newCategoryName" />
    <button v-on:click="postNewCategory">
      +
    </button>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data () {
    return {
      categories: [],
      newCategoryName: ''
    }
  },
  mounted () {
    this.fetchCategories()
  },
  methods: {
    fetchCategories () {
      fetch('http://localhost:8080/expenses/categories/')
        .then((response) => response.json())
        .then((data) => {
          this.categories = data
        })
    },
    postNewCategory () {
      const categoryToPost = {
        name: this.newCategoryName
      }
      fetch('http://localhost:8080/expenses/categories/', {
        method: 'POST',
        body: JSON.stringify(categoryToPost),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then((response) => response.json())
        .then((data) => {
          if (data.name) {
            this.fetchCategories()
          }
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
</style>
