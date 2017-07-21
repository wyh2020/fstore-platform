<template>
    <div>
        <h2>我是doneTodos</h2>
        <h4>{{doneTodos}}</h4>


        <h2>我是notDoneTodos</h2>
        <h4>{{notDoneTodos}}</h4>
    </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  export default {
    computed: mapGetters({
      doneTodos:'doneTodos',
      notDoneTodos:'notDoneTodos',
    })
  }
</script>

