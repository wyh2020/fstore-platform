<template>
    <div class="table_container">
        <el-table :data="tableData" highlight-current-row style="width: 100%">
            <el-table-column type="index" width="100">
            </el-table-column>
            <el-table-column property="name" label="姓名" width="220">
            </el-table-column>
            <el-table-column property="age" label="年龄" width="220">
            </el-table-column>
            <el-table-column property="password" label="密码">
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
  import BMFetch from '../../util/BMFetch'

  import Immutable from 'immutable'
  export default {
    data(){
      return {
        tableData: [],

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
        const Users = [];

        BMFetch({
          url: "/user/queryUserList",
          method: "GET",
        }).then((res)=> {
          let data = res.data;
          console.log("1111111Users===="+Immutable.fromJS(data))
          console.log("2222222Users===="+data)
          this.tableData = data.dataList;
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


