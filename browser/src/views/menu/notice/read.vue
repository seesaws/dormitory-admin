<template>
  <notice-detail :is-read="true" />
</template>

<script>
import NoticeDetail from './components/NoticeDetail'

export default {
  name: 'notice_read',
  components: { NoticeDetail }
}
</script>

