<template>
    <div id="app" class="fillcontain">
        <div class="manage_page fillcontain">
            <el-row style="height: 100%;">
                <Sidebar/>
                <el-col :span="20" style="height: 100%;overflow: auto;">
                    <div class="fillcontain">
                        <HeadTop/>
                        <keep-alive>
                            <router-view></router-view>
                        </keep-alive>
                    </div>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
  import Sidebar from './views/components/Sidebar.vue';
  import HeadTop from './views/components/HeadTop.vue'
  export default {
    name: 'app',
    components: { Sidebar,HeadTop },
  }
</script>

<style lang="less">
    @import './styles/common';
</style>