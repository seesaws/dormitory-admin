<template>
  <notice-detail :is-edit="false"/>
</template>

<script>
import NoticeDetail from './components/NoticeDetail'

export default {
  name: 'notice_create',
  components: { NoticeDetail }
}
</script>

