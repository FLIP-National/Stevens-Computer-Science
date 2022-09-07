const path = require("path")

const constructorMethod = app => {
  app.get("/", (req, res) => {
   res.sendFile(path.resolve("./public/index.html"))
  })

  app.use("*", (req, res) => {
    res.status(404).json({ error: "Sorry, the page you are looking for is not found" })
  })
}

module.exports = constructorMethod