<template>
  <div id="app">
    <router-view :key="$route.fullPath"></router-view>
  </div>

</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  margin: 0;
  padding: 0
}
</style>
