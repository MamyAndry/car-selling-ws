package carselling.selling.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "model_motor")
public class ModelMotor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_model_motor")
	Integer idModelMotor;
	@ManyToOne
	@JoinColumn(name = "id_motorisation")
	Motorisation motorisation;
	@ManyToOne
	@JoinColumn(name = "id_model")
	Model model;




	public ModelMotor(){}

	public Integer getIdModelMotor(){
		return this.idModelMotor;
	}
	public void setIdModelMotor(Integer idModelMotor){
		this.idModelMotor = idModelMotor;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	


}
