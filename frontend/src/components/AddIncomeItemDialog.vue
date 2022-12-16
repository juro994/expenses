<template>
      <v-dialog
      v-model="dialog"
      max-width="500px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn v-bind="attrs" v-on="on" icon>
          <v-icon>mdi-plus-circle</v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-title>
          <span class="headline">Add a new Income</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col
                cols="12"
                sm="12"
                md="8"
              >
                <v-text-field
                  label="Title*"
                  required
                  v-model="newIncomeItemName"
                ></v-text-field>
              </v-col>
              <v-col
                cols="12"
                sm="12"
                md="4"
              >
                <v-text-field
                  label="Amount*"
                  required
                  v-model="newIncomeItemAmount"
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
            @click="postNewIncomeItem"
          >
            Save
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
import Vue from 'vue'
import { postRequest } from '../utils/httpUtils'

export default Vue.extend({
  name: 'addIncomeItemDialog',
  components: {
  },
  props: {
    category: Object
  },
  data () {
    return {
      dialog: false,
      newIncomeItemName: '',
      newIncomeItemAmount: null
    }
  },
  methods: {
    postNewIncomeItem () {
      const incomeItemToPost = {
        name: this.newIncomeItemName,
        amount: this.newIncomeItemAmount
      }
      postRequest('income/', incomeItemToPost)
        .then((response) => response.json())
        .then((data) => {
          if (data.status && data.status !== 'OK') {
            alert(data.message)
          }
          if (data.name) {
            this.$emit('newIncomeItemAdded')
            this.dialog = false
          }
        })
    }
  }
})
</script>
