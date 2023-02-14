<script setup>
import Header from "./components/Header.vue";
import Page1 from "./components/Page1.vue";
import Page2 from "./components/Page2.vue";
</script>

<script>
export default {
  data() {
    return {
      currentPage:1,
    };
  },
}
</script>

<template>
  <header>
    <Header page="1" @response="(msg) => currentPage = msg"/>
  </header>

  <main>
    <div v-if="currentPage == 1">
      <Page1 />
    </div>
    <div v-if="currentPage == 2">
      <Page2 />
    </div>
  </main>
</template>