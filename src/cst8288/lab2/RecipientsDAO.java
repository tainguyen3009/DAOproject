/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.lab2;

import java.util.List;

/**
 *
 * @author Tai Nguyen
 * interface class that contain DAO
 */
public interface RecipientsDAO {
    List<RecipientsDTO> getAllReciepients();
    RecipientsDTO getReciepientsByAwardID(Integer awardID);
    void addRecipient (RecipientsDTO recipient);
    void updateRecipient (RecipientsDTO recipient);
    void deleteRepcipient (RecipientsDTO recipient);
}
