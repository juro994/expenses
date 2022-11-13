<template>
  <v-container fill-height>
    <v-row
      justify="center"
      align="center"
    >
      <v-col
        md="4"
      >
        <v-card>
          <v-card-title>
            Register new user
          </v-card-title>
          <v-card-text>
            <v-container>
            <v-row>
              <v-col
                cols="12"
              >
                <v-text-field
                  v-model="username"
                  :rules="nameRules"
                  :counter="10"
                  label="Username"
                  required
                ></v-text-field>
              </v-col>

              <v-col
                cols="12"
              >
                <v-text-field
                  v-model="firstName"
                  :rules="nameRules"
                  :counter="10"
                  label="First name"
                  required
                ></v-text-field>
              </v-col>

              <v-col
                cols="12"
              >
                <v-text-field
                  v-model="lastName"
                  :rules="nameRules"
                  :counter="10"
                  label="Last name"
                  required
                ></v-text-field>
              </v-col>

              <v-col
                cols="12"
              >
                <v-text-field
                  v-model="password"
                  :rules="emailRules"
                  type="password"
                  label="Password"
                  required
                ></v-text-field>
              </v-col>
            </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-btn
            color="blue darken-1"
            text
            @click="register"
          >
            Register
          </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
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
