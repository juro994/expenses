<template>
  <div>
    <h1>This is a login page</h1>
    <v-container>
      <v-row>
        <v-col cols="12" sm="12" md="7">
          <v-text-field
            label="username*"
            required
            v-model="username"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="3">
          <v-text-field
            label="password*"
            required
            v-model="password"
          >
            <v-icon slot="append"> mdi-currency-eur </v-icon>
          </v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="2">
          <v-btn
            color="blue darken-1"
            text
            @click="login"
          >
            Login
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
      password: null
    }
  },
  methods: {
    login () {
      const credentials = {
        username: this.username,
        password: this.password
      }
      fetch(process.env.VUE_APP_API_URL + 'login', {
        method: 'POST',
        body: JSON.stringify(credentials),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then((response) => response.text())
        .then((data) => {
          if (data.status && data.status !== 'OK') {
            alert('Wrong credentials!')
          }
          localStorage.setItem('jwt', data)
          this.$router.push('/')
        })
    }
  }
})
</script>
