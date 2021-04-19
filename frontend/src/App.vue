<template>
    <Main>
    </Main>
</template>

<script>
import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from './components/Main.vue'

Vue.use(VueRouter)

export default Vue.extend({
  name: 'App',

  components: {
    Main
  }
})
</script>
