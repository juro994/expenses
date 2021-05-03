<template>
  <div>
    <h1>This is a register page</h1>
    <v-container>
      <v-row>
        <v-col cols="12" sm="12" md="3">
          <v-text-field
            label="username*"
            required
            v-model="username"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="3">
          <v-text-field
            label="first name"
            required
            v-model="firstName"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="3">
          <v-text-field
            label="last name"
            required
            v-model="lastName"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="3">
          <v-text-field
            label="password*"
            required
            v-model="password"
          >
          </v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="2">
          <v-btn
            color="blue darken-1"
            text
            @click="register"
          >
            Register
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import Vue from 'vue'

export default Vue.extend({
  name: 'Login',
  props: {
  },
  components: {
  },
  data () {
    return {
      username: null,
      firstName: null,
      lastName: null,
      password: null
    }
  },
  methods: {
    register () {
      const credentials = {
        username: this.username,
        firstName: this.firstName,
        lastName: this.lastName,
        rawPassword: this.password
      }
      fetch(process.env.VUE_APP_API_URL + 'register', {
        method: 'POST',
        body: JSON.stringify(credentials),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then((response) => response.text())
        .then((data) => {
          if (data.status && data.status !== 'OK') {
            alert('Registration not succesful!')
          } else {
            this.$router.push('login')
          }
        })
    }
  }
})
</script>
