<template>
  <v-app>
    <v-app-bar app>
      <v-spacer></v-spacer>
      <v-btn
        icon
        @click="decreaseMonth"
      >
        <v-icon>mdi-arrow-left-circle</v-icon>
      </v-btn>
      <v-toolbar-title>{{currenctDateAsString}}</v-toolbar-title>
      <v-btn
        icon
        @click="increaseMonth"
      >
        <v-icon>mdi-arrow-right-circle</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
    </v-app-bar>
    <v-main>
      <v-container fluid>
        <v-row class="mx-md-10 mt-md-5">
          <v-col cols="12" lg="3" md="4" sm="6" xs="12" v-for="category in categories" v-bind:key="category.name">
            <category-with-expenses v-on:newCategoryAdded="fetchCategories" v-bind:category="category" />
          </v-col>
        </v-row>
      </v-container>
    </v-main>
    <add-category-dialog v-on:newCategoryAdded="fetchCategories" ref="addCategoryModal"/>
  </v-app>
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
      currentDate: null
    }
  },
  mounted () {
    this.setDefaultMonthAndYear()
    this.fetchCategories()
  },
  methods: {
    fetchCategories () {
      console.log(process.env.VUE_APP_API_URL)
      fetch(process.env.VUE_APP_API_URL + 'categories?month=' + (this.currentDate.getMonth() + 1) + '&year=' + this.currentDate.getFullYear())
        .then((response) => response.json())
        .then((data) => {
          if (data.status && data.status !== 'OK') {
            this.$router.push('login')
          }
          this.categories = data
        })
    },
    setDefaultMonthAndYear () {
      this.currentDate = new Date()
    },
    increaseMonth () {
      this.currentDate = new Date(this.currentDate.setMonth(this.currentDate.getMonth() + 1))
    },
    decreaseMonth () {
      this.currentDate = new Date(this.currentDate.setMonth(this.currentDate.getMonth() - 1))
    }
  },
  computed: {
    currenctDateAsString () {
      return this.currentDate ? this.currentDate.toLocaleString('en-US', { month: 'long', year: 'numeric' }) : ''
    }
  },
  watch: {
    currentDate: function () {
      this.fetchCategories()
    }
  }
})
</script>
