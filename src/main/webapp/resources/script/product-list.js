function buyNow(id) {
    console.log("id: " + id);

    fetch("http://localhost:8080/bucket/add", {
        method: 'POST',
        body: JSON.stringify({id: id})
    }).then(() => console.log("success"));
}