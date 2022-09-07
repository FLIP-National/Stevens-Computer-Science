const mongoCollections = require('../config/mongoCollections');
const recipes = mongoCollections.recipes;
const { ObjectId } = require('mongodb');
const validation = require('../validation');

const exportedMethods = {
  async getAllRecipes() {
    const recipeCollection = await recipes();
    return await recipeCollection.find({}).toArray();
  },
  async getRecipeById(id) {
    id = validation.checkId(id, 'ID');
    const recipeCollection = await recipes();
    const recipe = await recipeCollection.findOne({ _id: ObjectId(id) });

    if (!recipe) throw 'Recipe not found';
    return recipe;
  },
  async addRecipe(title, ingredients, steps) {
    title = validation.checkString(title, 'Title');
    if (!Array.isArray(steps)) {
      steps = [];
    } else {
      steps = validation.checkStringArray(steps, 'Steps');
    }

    const recipeCollection = await recipes();


    const newRecipe = {
      title: title,
      ingredients: ingredients,
      steps: steps
    };
    const newInsertInformation = await recipeCollection.insertOne(newRecipe);
    const newId = newInsertInformation.insertedId;
    return await this.getRecipeById(newId.toString());
  },
  async removeRecipe(id) {
    id = validation.checkId(id, 'ID');
    const recipeCollection = await recipes();

    try {
      const recipe = await this.getRecipeById(id);
    } catch (e) {
      console.log(e);
      return;
    }
    const deletionInfo = await recipeCollection.deleteOne({ _id: ObjectId(id) });
    if (deletionInfo.deletedCount === 0) {
      throw `Could not delete recipe with id of ${id}`;
    }
    return true;
  },
  async updateRecipe(id, updatedRecipe) {
    const recipeCollection = await recipes();

    const updatedRecipeData = {};

    if (updatedRecipe.steps) {
      updatedRecipeData.steps = validation.checkStringArray(
        updatedRecipe.steps,
        'Steps'
      );
    }

    if (updatedRecipe.title) {
      updatedRecipeData.title = validation.checkString(
        updatedRecipe.title,
        'Title'
      );
    }

    if (updatedRecipe.ingredients) {
      updatedRecipeData.ingredients = updatedRecipe.ingredients;
    }

    await recipeCollection.updateOne(
      { _id: ObjectId(id) },
      { $set: updatedRecipeData }
    );

    return await this.getRecipeById(id);
  }
};

module.exports = exportedMethods;
