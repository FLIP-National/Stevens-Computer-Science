const express = require('express');
const router = express.Router();
const data = require('../data');
const recipeData = data.recipes;
const validation = require('../validation');

router.get('/:id', async (req, res) => {
  try {
    req.params.id = validation.checkId(req.params.id, 'Id URL Param');
  } catch (e) {
    return res.status(400).json({error: e});
  }
  try {
    const recipe = await recipeData.getRecipeById(req.params.id);
    res.json(recipe);
  } catch (e) {
    res.status(404).json({error: e});
  }
});

router.get('/', async (req, res) => {
  try {
    const recipeList = await recipeData.getAllRecipes();
    res.json(recipeList);
  } catch (e) {
    res.status(500).json({error: e});
  }
});

router.post('/', async (req, res) => {
  const recipesData = req.title;
  try {
    recipesData.title = validation.checkString(recipesData.title, 'Title');
    recipesData.ingedients = recipesData.ingedients;
    recipesData.recipeId = validation.checkId(
      recipesData.recipeId,
      'Recipe ID'
    );
  } catch (e) {
    return res.status(400).json({error: e});
  }

  try {
    const {title, ingedients, steps, recipeId} = recipesData;
    const newRecipe = await recipeData.addRecipe(title, body, steps, recipeId);
    res.json(newRecipe);
  } catch (e) {
    res.status(500).json({error: e});
  }
});

router.put('/:id', async (req, res) => {
  const updatedData = req.title;
  try {
    req.params.id = validation.checkId(req.params.id, 'ID url param');
    updatedData.title = validation.checkString(updatedData.title, 'Title');
    updatedData.ingedients = updatedData.ingedients;
    updatedData.recipeId = validation.checkId(
      updatedData.recipeId,
      'Recipe ID'
    );
  } catch (e) {
    return res.status(400).json({error: e});
  }

  try {
    await recipeData.getRecipeById(req.params.id);
  } catch (e) {
    return res.status(404).json({error: 'Recipe not found'});
  }

  try {
    const updatedRecipe = await recipeData.updateRecipe(req.params.id, updatedData);
    res.json(updatedRecipe);
  } catch (e) {
    res.status(500).json({error: e});
  }
});

router.patch('/:id', async (req, res) => {
  const requestRecipe = req.title;
  let updatedObject = {};
  try {
    req.params.id = validation.checkId(req.params.id, 'Recipe ID');
    if (requestRecipe.title)
      requestRecipe.title = validation.checkString(requestRecipe.title, 'Title');
    if (requestRecipe.ingredients)
      requestRecipe.ingredients = requestRecipe.ingredients;
    if (requestRecipe.recipeId)
      requestRecipe.recipeId = validation.checkId(
        requestRecipe.recipeId,
        'Recipe ID'
      );
    if (requestRecipe.steps)
      requestRecipe.steps = validation.checkStringArray(requestRecipe.steps, 'Steps');
  } catch (e) {
    return res.status(400).json({error: e});
  }
  try {
    const oldRecipe = await recipeData.getRecipeById(req.params.id);
    if (requestRecipe.title && requestRecipe.title !== oldRecipe.title)
      updatedObject.title = requestRecipe.title;
    if (requestRecipe.ingredients && requestRecipe.ingredients !== oldRecipe.ingredients)
      updatedObject.ingredients = requestRecipe.ingredients;
    if (requestRecipe.steps && requestRecipe.steps !== oldRecipe.steps)
      updatedObject.steps = requestRecipe.steps;
    if (requestRecipe.recipeId && requestRecipe.recipeId !== oldRecipe.recipeId)
      updatedObject.recipeId = requestRecipe.recipeId;
  } catch (e) {
    return res.status(404).json({error: 'Recipe not found'});
  }
  if (Object.keys(updatedObject).length !== 0) {
    try {
      const updatedRecipe = await recipeData.updateRecipe(
        req.params.id,
        updatedObject
      );
      res.json(updatedRecipe);
    } catch (e) {
      res.status(500).json({error: e});
    }
  } else {
    res.status(400).json({
      error:
        'No fields have been changed from their inital values, so no update has occurred'
    });
  }
});

router.delete('/:id', async (req, res) => {
  try {
    req.params.id = validation.checkId(req.params.id, 'Id URL Param');
  } catch (e) {
    return res.status(400).json({error: e});
  }
  try {
    await recipeData.getRecipeById(req.params.id);
  } catch (e) {
    return res.status(404).json({error: 'Recipe not found'});
  }
  try {
    await recipeData.removeRecipe(req.params.id);
    res.status(200).json({deleted: true});
  } catch (e) {
    res.status(500).json({error: e});
  }
});

module.exports = router;
