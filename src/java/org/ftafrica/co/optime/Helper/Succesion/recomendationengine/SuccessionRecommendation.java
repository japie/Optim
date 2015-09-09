/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.Succesion.recomendationengine;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

/**
 *
 * @author Training 8
 */

public class SuccessionRecommendation {

    public SuccessionRecommendation() {
    }
    
    public List<RecommendedItem> MakeRecommendation(long userId,int noOfRecommendations) {
		List<RecommendedItem> recommendations = null;

		// specifying the user id to which the recommendations have to be
		// generated for
		// userId=9;

		// specifying the number of recommendations to be generated
		// noOfRecommendations=2;

		try {
			// Data model created to accept the input file
			FileDataModel dataModel = new FileDataModel(new File("C:\\Users\\8460p\\Documents\\Optim Share\\project updated\\___Master____\\optim\\data\\data.csv"));

			/* Specifies the Similarity algorithm */
			//ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
			TanimotoCoefficientSimilarity itemSimilarity = new TanimotoCoefficientSimilarity(dataModel);
			/* Initalizing the recommender */
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);

			// calling the recommend method to generate recommendations
			recommendations = recommender.recommend(userId, noOfRecommendations);

			
			//  for (RecommendedItem recommendedItem : recommendations)
			// System.out
			//  .println(recommendedItem.getItemID()+"   "+recommendedItem
			// .getValue()*100);
			 
		} catch (IOException | TasteException e) {
		}
                   
		return recommendations;

	}
    
    
}
