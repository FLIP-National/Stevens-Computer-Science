const dbConnection = require('../config/mongoConnection');
const data = require('../data/');
const recipes = data.recipes;

async function main() {
  const db = await dbConnection.dbConnection();
  await db.dropDatabase();

  const ingredients = [{
    name: "Egg",
    amount: "2 eggs"
  },
  {
    name: "Olive Oil",
    amount: "2 tbsp"
  }]

  await recipes.addRecipe(
    'Fried Eggs',
    ingredients,
    [
      "Put two slices of bread in the toaster oven at 350 for 3 to 5 minutes.",
      "Remove bread from toaster and spread with desired amount of butter",
      "Enjoy your toast!"
    ]
  );

  console.log('Done seeding database');

  await dbConnection.closeConnection();
}

main();
