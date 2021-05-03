<template>
      <v-dialog
      v-model="dialog"
      max-width="500px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
        v-bind="attrs"
        v-on="on"
        elevation="3"
        fab
        fixed right bottom
      ><v-icon>mdi-card-plus</v-icon></v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">Add a new Category</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col
                cols="12"
                sm="12"
                md="7"
              >
                <v-text-field
                  label="Title*"
                  required
                  v-model="newCategoryName"
                ></v-text-field>
              </v-col>
              <v-col
                cols="12"
                sm="12"
                md="5"
              >
                <v-text-field
                  label="Monthly budget*"
                  required
                  v-model="newMonthlyBudget"
                >
                <v-icon
                  slot="append"
                >
                  mdi-currency-eur
                </v-icon>
                </v-text-field>
              </v-col>
            </v-row>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue darken-1"
            text
            @click="dialog = false"
          >
            Close
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="postNewCategory"
          >
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
import Vue from 'vue'
import {postRequest} from '../utils/httpUtils'

export default Vue.extend({
  name: 'addCategoryDialog',
  components: {
  },
  props: {
    category: Object
  },
  data () {
    return {
      dialog: false,
      newCategoryName: '',
      newMonthlyBudget: null
    }
  },
  methods: {
    postNewCategory () {
      const categoryToPost = {
        name: this.newCategoryName,
        monthlyBudget: this.newMonthlyBudget
      }
      postRequest('categories/', categoryToPost)
        .then((response) => response.json())
        .then((data) => {
          if (data.status && data.status !== 'OK') {
            alert(data.message)
          }
          if (data.name) {
            this.$emit('newCategoryAdded')
            this.dialog = false
          }
        })
    }
  }
})
</script>
