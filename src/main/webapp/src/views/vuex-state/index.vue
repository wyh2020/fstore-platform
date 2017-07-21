<template>
    <div>
        <h2>我是count</h2>
        <div>{{count}}</div>
    </div>
</template>

<script>
  export default {
    computed: {
      count(){
        return this.$store.state.count;
      }
    }
  }
</script>

