<script>
export default {
	props: {
		idSalle: Number,
        required: true,
	},
    data() {
		return {
			idS: parseInt(this.idSalle),
		};
	}
};
</script>

<template>
    <div class="salle">
        <h1>Salle {{ idS }}</h1>
    </div>
</template>