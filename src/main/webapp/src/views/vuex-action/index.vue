<template>
    <div>
        <h2>我是count===>Action</h2>
        <div>{{count}}</div>

        <button  type="primary" @click="add">递增按钮</button>

    </div>
</template>

<script>
    import {mapActions} from 'vuex';
  export default {

    computed: {
      count(){
        return this.$store.state.count;
      }
    },

    methods: mapActions({
      add:'increment'
    })
  }
</script>

