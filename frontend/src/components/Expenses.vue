<template>
<v-expand-transition>
  <div v-if="expenses && expenses.length > 0">
    <v-data-table class="expenses-table" :headers="headers" :items="expenses" :mobile-breakpoint="0" hide-default-footer >
      <template v-slot:top>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title >Confirm delete</v-card-title>
            <v-card-text>Are you sure you want to delete <strong>{{editedItem.name}}</strong>?</v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="gray darken-1" text @click="closeDelete">Cancel</v-btn>
              <v-btn color="red darken-1" text @click="deleteItemConfirm">Delete</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </template>
      <!-- <template v-slot:item.modified="{ item }">
        {{ getFormattedDate(item.modified) }}
      </template>
      <template v-slot:item.amount="{ item }">
        {{ item.amount }} €
      </template> -->
      <!-- <template v-slot:item.actions="{ item }">
        <v-icon
          small
          @click="deleteItem(item)"
        >
          mdi-close
        </v-icon>
      </template> -->
      <template
        v-slot:body="{ items }"
      >
        <tbody>
          <tr
            v-for="item in items"
            :key="item.name"
          >
            <td style="padding: 0 8px 0 16px; width: 44%;">{{ item.name }}</td>
            <td style="padding: 0 8px 0 8px; width: 24%;">{{ getFormattedDate(item.modified) }}</td>
            <td style="padding: 0 8px 0 8px; width: 24%;">{{ item.amount }} €</td>
            <td style="padding: 0 16px 0 8px; width: 3%;"><v-icon
          small
          @click="deleteItem(item)"
        >
          mdi-close
        </v-icon></td>
          </tr>
        </tbody>
      </template>
    </v-data-table>
  </div>
</v-expand-transition>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
    expenses: Array
  },
  data () {
    return {
      headers: [
        { text: 'Name', value: 'name' },
        { text: 'Date', value: 'modified' },
        { text: '€', value: 'amount' },
        { text: '', value: 'actions', sortable: false }
      ],
      editedIndex: -1,
      hoveredItem: null,
      editedItem: {
        id: 0,
        name: '',
        modified: null,
        amount: 0
      },
      defaultItem: {
        id: 0,
        name: '',
        modified: null,
        amount: 0
      },
      dialogDelete: false
    }
  },
  methods: {
    getFormattedDate (dateString) {
      const date = new Date(dateString)
      const options = { day: 'numeric', month: 'numeric' }
      return date.toLocaleDateString('sk-SK', options)
    },
    deleteItem (item) {
      this.editedIndex = this.expenses.indexOf(item)
      this.editedItem = Object.assign({}, item)
      this.dialogDelete = true
    },
    deleteItemConfirm () {
      this.expenses.splice(this.editedIndex, 1)
      this.closeDelete()
    },
    closeDelete () {
      this.dialogDelete = false
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },
    hoverOverItem (item) {
      this.hoveredItem = item
    },
    leaveHoveredItem () {
      this.hoveredItem = null
    }
  }
})
</script>

<style>
.expenses-table {
  table-layout: fixed;
  text-align: left;
}
</style>
