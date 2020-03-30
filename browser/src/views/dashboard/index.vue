<template>
  <div class="app-container">
    <el-table
      :data="tableData"
      :default-sort = "{prop: 'publishtime', order: 'descending'}"
      v-loading.body="tableLoading"
      element-loading-text="加载中"
      border fit highlight-current-row
      style="width: 100%">
      <el-table-column
        prop="publishtime"
        label="日期"
        width="180">
        <template slot-scope="scope">
          <el-tag style="margin: 2px;" v-for="notice in scope.row.roleList" :key="notice.nid">{{notice.publishtime}}</el-tag>
        </template>
        <template slot-scope="scope">
          <span v-text="parseTime(scope.row.publishtime)"></span>
        </template>
      </el-table-column>


      <el-table-column min-width="300px" label="标题" header-align="center">
        <template slot-scope="{row}">
          <router-link :to="'/notice_manage/read/'+row.nid" class="link-type">
            <span>{{ row.title }}</span>
          </router-link>
        </template>
      </el-table-column>

      <el-table-column
        prop="author"
        label="作者"
        width="180">
      </el-table-column>

    </el-table>
    <div class="pagination">
    <el-pagination
    background
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="tablePage.current"
      :page-sizes="[10, 20, 30, 40, 50]"
      :page-size="tablePage.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="tablePage.total">
    </el-pagination>
    </div>
  </div>
</template>

<script>
  import { fetchList } from '@/api/notice'
  import { parseTime } from '@/utils'
  import { pageParamNames } from '@/utils/constants'

  export default {

    name: 'home',
    data() {
      return {
        parseTime: parseTime,
        tableLoading: false,
        tableData: [],
        tablePage: {
          current: null,
          pages: null,
          size: null,
          total: null
        }

      }
    },
    created() {
      this.initData()
      this.fetchData()
    },
    methods: {
      initData() {

      },
      // 分页
      handleSizeChange(val) {
        this.tablePage.size = val
        this.fetchData()
      },
      handleCurrentChange(val) {
        this.tablePage.current = val
        this.fetchData()
      },
      // 查询
      fetchData() {
        this.tableLoading = true
        fetchList(this.tablePage).then(res => {
          this.tableData = res.data.page.records
          this.tableLoading = false
          pageParamNames.forEach(name => this.$set(this.tablePage, name, res.data.page[name]))
        })
      }
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
pagination{
text-align: center;
}
</style>
