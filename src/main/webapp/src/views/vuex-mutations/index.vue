<template>
    <div>
        <h2>我是count</h2>
        <div>{{count}}</div>

        <button  type="primary" @click="add">递增按钮</button>

    </div>
</template>

<script>
    import {mapMutations} from 'vuex';
  export default {

    computed: {
      count(){
        return this.$store.state.count;
      }
    },

    methods: mapMutations({
      add:'increment'
    })
  }
</script>

