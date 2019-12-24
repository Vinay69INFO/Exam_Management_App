
package com.vinay.org.dao;

import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Subject;
import java.util.List;
import java.util.Set;


public interface SubjectDao {
    public void Save(Subject sub);
    public void Update(Subject sub);
    public void Delete(Subject sub);
    public void DeleteById(Integer id);
    public Subject FindById(Integer id);
    public List<Subject> FindAll();
    public List<Questions> findBySubject(Subject sub);
    
}
