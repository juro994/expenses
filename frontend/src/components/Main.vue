<template>
  <div class="hello">
    <h1>My Expenses for {{monthName}} {{year}}</h1>
    <div class="categories-with-expenses">
      <template v-for="category in categories">
        <category-with-expenses v-on:newCategoryAdded="fetchCategories" v-bind:key="category.name" v-bind:category="category" />
      </template>
      <button class="add-category-button shadow-effect" @click="$refs.addCategoryModal.openModal()">+</button>
      <add-category-dialog v-on:newCategoryAdded="fetchCategories" ref="addCategoryModal"/>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import CategoryWithExpenses from './CategoryWithExpenses.vue'
import AddCategoryDialog from './AddCategoryDialog.vue'

export default Vue.extend({
  name: 'Main',
  props: {
  },
  components: {
    CategoryWithExpenses,
    AddCategoryDialog
  },
  data () {
    return {
      categories: [],
      month: null,
      year: null
    }
  },
  mounted () {
    this.setDefaultMonthAndYear()
    this.fetchCategories()
  },
  methods: {
    fetchCategories () {
      console.log(process.env.VUE_APP_API_URL)
      fetch(process.env.VUE_APP_API_URL + 'categories?year=' + this.year + '&month=' + (this.month + 1))
        .then((response) => response.json())
        .then((data) => {
          this.categories = data
        })
    },
    setDefaultMonthAndYear () {
      const today = new Date()
      this.month = today.getMonth()
      this.year = today.getFullYear()
    }
  },
  computed: {
    monthName () {
      // today.toLocaleString('en-US', { month: 'long' })
      return 'March'
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

.add-category-button {
  border-radius: 100%;
  border: 1px solid white;
  background-color: gainsboro;
  color: white;
  height: 30px;
  width: 30px;
  margin: 10px;
}

.add-category-button:hover {
  filter: brightness(105%);
}
.add-category-button:active {
  filter: brightness(95%);
}

.shadow-effect {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 2px 4px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
}

/* On mouse-over, add a deeper shadow */
.shadow-effect:hover {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}
</style>
