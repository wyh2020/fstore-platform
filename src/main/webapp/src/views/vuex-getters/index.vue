<template>
    <div>
        <h2>我是doneTodosCount</h2>
        <h4>{{doneTodosCount}}</h4>
    </div>
</template>

<script>
  import {mapGetters} from 'vuex';
  export default {
    computed: {
      doneTodosCount () {
        console.log("doneTodosCount12121===" + this.$store.getters.doneTodosCount)
        return this.$store.getters.doneTodos
      }
    }
  }
</script>

