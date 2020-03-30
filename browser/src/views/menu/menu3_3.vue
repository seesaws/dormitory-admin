<template>
  <div class="dashboard-editor-container">




  </div>

</template>


<script>
  // 默认导出
  export default {
    name: 'shcoolinfo',

    data() {
      return {

      }
    },
    computed: {

    },
    created() {
      this.initData()
    },
    methods: {

      initData() {

      }

    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>

  .dashboard-editor-container {
    background-color: #F2F6FC;
    min-height: 100vh;
    padding: 50px 60px 0px;
    .pan-info-roles {
      font-size: 12px;
      font-weight: 700;
      color: #333;
      display: block;
    }
    .info-container {
      position: relative;
      margin-left: 190px;
      height: 80px;
      /*line-height: 80px;*/
      .display_name {
        font-size: 38px;
        line-height: 38px;
        color: #212121;
        position: absolute;
        top: 25px;
      }
    }
  }

</style>
