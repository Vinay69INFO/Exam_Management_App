/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.Options;
import com.vinay.org.entity.Questions;
import java.util.List;
import java.util.Set;

/**
 *
 * @author vinay
 */
public interface OptionsDao {
    public void Save(Options option);
    public void Update(Options option);
    public void Delete(Options option);
    public void DeleteById(Integer id);
    public Options FindById(Integer id);
    public List<Options> FindAll();
    public List<Options> findByQuestion(Questions question);
}
