<template>
    <div class="table_container">
        <el-table :data="tableData" highlight-current-row style="width: 100%">
            <el-table-column type="index" width="100">
            </el-table-column>
            <el-table-column property="registe_time" label="注册日期" width="220">
            </el-table-column>
            <el-table-column property="username" label="用户姓名" width="220">
            </el-table-column>
            <el-table-column property="city" label="注册地址">
            </el-table-column>
        </el-table>
        <div class="Pagination" style="text-align: left;margin-top: 10px;">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-size="20"
                    layout="total, prev, pager, next"
                    :total="count">
            </el-pagination>
        </div>
    </div>
</template>

<script>
  import {getUserList} from '../../api/getData'
  export default {
    data(){
      return {
        tableData: [{
          registe_time: '2016-05-02',
          username: '王小虎',
          city: '上海市普陀区金沙江路 1518 弄'
        }, {
          registe_time: '2016-05-04',
          username: '王小虎',
          city: '上海市普陀区金沙江路 1517 弄'
        }, {
          registe_time: '2016-05-01',
          username: '王小虎',
          city: '上海市普陀区金沙江路 1519 弄'
        }, {
          registe_time: '2016-05-03',
          username: '王小虎',
          city: '上海市普陀区金沙江路 1516 弄'
        }],

        currentRow: null,
        offset: 0,
        limit: 20,
        count: 0,
        currentPage: 1,
      }
    },
    created(){
      this.initData();
    },
    methods: {
      initData(){
        console.log("ddd")
        try {
          this.getUsers();
        } catch (err) {
          console.log('获取数据失败', err);
        }
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        this.currentPage = val;
        this.offset = (val - 1) * this.limit;
//            this.getUsers()
      },
      getUsers(){
        const Users = getUserList();
        console.log("Users===="+Users)
        this.tableData = [];
        Users.forEach(item => {
          const tableData = {};
          tableData.username = item.username;
          tableData.registe_time = item.registe_time;
          tableData.city = item.city;
          this.tableData.push(tableData);
        })
      }
    },
  }
</script>

<style lang="less">
    @import '../../styles/mixin';

    .table_container {
        padding: 20px;
    }
</style>


